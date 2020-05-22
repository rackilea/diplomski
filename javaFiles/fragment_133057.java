Iterator<Map.Entry<String,String>> holyDayiterator = workingdayMap.entrySet().iterator();

                 while (holyDayiterator.hasNext()) {
                    Map.Entry holiDayEntry = holyDayiterator.next();
                    if(!employeeMap.containsValue((holiDayEntry.getValue()))){
                        System.out.println("works perfect");
                    }