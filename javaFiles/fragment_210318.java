JavaRDD<String> JsonObject = json_Batch.javaRDD().flatMap(f -> {
            String res = f.getAs("Batch_Address").toString();


             JSONArray jsonArr = new JSONArray(res);


            List<String> list = StreamSupport.stream(jsonArr.spliterator(), false)
                    .map(val ->   val.toString())

                    .collect(Collectors.toCollection( ArrayList::new ));

            return list.iterator();

        }); 

        JsonObject.foreach(f -> System.out.println(f));