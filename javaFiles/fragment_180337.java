Map<String,List<String>> input = ...; // from step 1.
   Map<String,List<String>> allowed = ...; // from step 3.
   Map<String,List<String>> result = new HashMap<String<list<String>>(); // the final map
   for (String key : input.keySet()) {
      if (allowd.contains(key)) {
         List<String> outputValues = new ArrayList();
         List<String> allowedValues = allowed.get(key);
         List<String> inputValues = input.get(key);
         for (String value: inputValues) {
            if (allowedValues.contains(value))
                outputValues.add(value);
         }
         if (!outputValues.isEmpty())
            output.put(key, outputValues);
      }
   }
   // final result in filter