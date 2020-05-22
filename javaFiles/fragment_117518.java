List<List <Double>> tmp =   (List< List<Double>>)    person.get("hours");
                List<Double> tmp1 = tmp.get(0);
                tmp1.set(1, 5.0);
                tmp1.set(2, 5.0);
                tmp1.set(3, 5.0);
                tmp1.set(4, 5.0);
                tmp1.set(5, 5.0);
                tmp1.set(6, 5.0);

                tmp.set(2, tmp1);

                person.put("hours", tmp);