/***
 Copyright (c) 2016 CommonsWare, LLC

 Licensed under the Apache License, Version 2.0 (the "License"); you may
 not use this file except in compliance with the License. You may obtain
 a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.commonsware.agql.client.local;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import graphql.Scalars;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

// schema inspired by https://gist.github.com/gsans/d857b0951077bdbbabd968e0431d97fe

public class TestSchema {
  private static class ToDo {
    public int id;
    public String text;
    public boolean complete;

    ToDo(int id, String text, boolean complete) {
      this.id=id;
      this.text=text;
      this.complete=complete;
    }
  }

  private static ArrayList<ToDo> TODOES=new ArrayList<>();

  static {
    TODOES.add(new ToDo(123, "get this sample working", false));
    TODOES.add(new ToDo(4567, "add more test cases", false));
    TODOES.add(new ToDo(89012, "add more documentation", false));
    TODOES.add(new ToDo(345678, "add more todoes", false));
  }

  private static GraphQLFieldDefinition id=
    GraphQLFieldDefinition
      .newFieldDefinition()
      .name("id")
      .description("unique identifier")
      .type(Scalars.GraphQLInt)
      .build();

  private static GraphQLFieldDefinition text=
    GraphQLFieldDefinition
      .newFieldDefinition()
      .name("text")
      .description("what is to be done")
      .type(Scalars.GraphQLString)
      .build();

  private static GraphQLFieldDefinition complete=
    GraphQLFieldDefinition
      .newFieldDefinition()
      .name("complete")
      .description("are we done yet?")
      .type(Scalars.GraphQLBoolean)
      .build();

  private static GraphQLObjectType todo=
    GraphQLObjectType.newObject()
      .name("Todo")
      .description("Something to be done")
      .field(id)
      .field(text)
      .field(complete)
      .build();

  private static GraphQLArgument skip=
    GraphQLArgument
      .newArgument()
      .name("skip")
      .description("return starting with this index")
      .type(Scalars.GraphQLInt)
      .build();

  private static GraphQLArgument take=
    GraphQLArgument
      .newArgument()
      .name("take")
      .description("return this number of todoes")
      .type(Scalars.GraphQLInt)
      .build();

  private static DataFetcher fetcher=new DataFetcher() {
    @Override
    public Object get(DataFetchingEnvironment env) {
      int startIndex=0;
      int endIndex=TODOES.size()-1;
      List<ToDo> result=null;

      try {
        if (env.containsArgument("skip")) {
          Integer skip=env.getArgument("skip");

          if (skip!=null) {
            startIndex=skip.intValue();
          }
        }

        if (env.containsArgument("take")) {
          Integer take=env.getArgument("take");

          if (take!=null) {
            endIndex=startIndex+take;
          }
        }

        result=TODOES.subList(startIndex, endIndex);
      }
      catch (Exception e) {
        Log.e(getClass().getSimpleName(), "Exception processing request", e);
        // um, how do I get this error into result?
      }

      return(result);
    }
  };

  private static GraphQLFieldDefinition allTodoes=
    GraphQLFieldDefinition
      .newFieldDefinition()
      .name("allTodoes")
      .type(new GraphQLList(todo))
      .argument(skip)
      .argument(take)
      .dataFetcher(fetcher)
      .build();

  private static GraphQLObjectType rootQuery=
    GraphQLObjectType
      .newObject()
      .name("rootQuery")
      .field(allTodoes)
      .build();

  public static GraphQLSchema schema=
    GraphQLSchema.newSchema().query(rootQuery).build();
}