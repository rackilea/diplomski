package com.example.cgwyllie.simplelistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kumulos.android.jsonclient.Kumulos;
import com.kumulos.android.jsonclient.ResponseHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {

    static class Person {

        public long personID;
        public String firstName;
        public String lastName;

        public static Person createFromGenericMap(Map<String, Object> object) {
            Person p = new Person();

            p.personID = (long) object.get("personID");
            p.firstName = (String) object.get("firstName");
            p.lastName = (String) object.get("lastName");

            return p;
        }

    }

    static class PersonAdapter extends BaseAdapter {

        private List<Person> people;

        public PersonAdapter(List<Person> people) {
            this.people = people;
        }

        @Override
        public int getCount() {
            return people.size();
        }

        @Override
        public Object getItem(int position) {
            return people.get(position);
        }

        @Override
        public long getItemId(int position) {
            Person p = people.get(position);
            return p.personID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO implement your view
            return null;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Kumulos.initWithAPIKeyAndSecretKey("API_KEY", "SECRET_KEY", this);

        // Call Kumulos
        Map<String,String> params = new HashMap<>();
        Kumulos.call("getPeople", params, new ResponseHandler() {

            // Handle result
            @Override
            public void didCompleteWithResult(Object result) {
                super.didCompleteWithResult(result);

                // Cast generic response down to list of maps
                ArrayList<LinkedHashMap<String, Object>> objects = (ArrayList<LinkedHashMap<String,Object>>) result;

                // Create a list for the models
                ArrayList<Person> people = new ArrayList<>();

                // Map models from generic objects and add to list
                for (Map<String,Object> personObject : objects) {
                    Person p = Person.createFromGenericMap(personObject);
                    people.add(p);
                }

                // Create adapter with model list
                final PersonAdapter adapter = new PersonAdapter(people);

                // Set adapter on main UI thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setListAdapter(adapter);
                    }
                });
            }
        });
    }
}