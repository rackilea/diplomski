Genson genson = new GensonBuilder()
    .addAlias("ComplexCondition", ComplexCondition.class)
    .addAlias("SimpleCondition", SimpleCondition.class)
    .create();

{
  "@class": "ComplexCondition",
  "left": {
            "@class": "SimpleCondition",
            "feature":"locality",
            "op":"==",
            "value":"Chino",
            "primitive":9
          },
  "joint":"and",
  "right": {
            "@class": "SimpleCondition",
              "feature":"ch4",
              "op":">=",
              "value":"1.5",
              "primitive":3
           }
}