Arrays.stream(csvString.split("\r?\n"))
                .map(x -> x.split(","))
                .map(Arrays::asList)
                .map(PhoneCall::new) //Stream<PhoneCall>
                .collect(Collectors.groupingBy(x -> x.phoneNumber)) //Map<String, List<PhoneCall>>
                .values() 
                .stream()



    private static class PhoneCall {
        final String phoneNumber;
        final int hours;
        final int minutes;
        final int seconds;


        PhoneCall(List<String> values) {
            phoneNumber = values.get(1);
            String[] durationArray = values.get(0).split(":");
            hours = Integer.valueOf(durationArray[0]);
            minutes = Integer.valueOf(durationArray[1]);
            seconds = Integer.valueOf(durationArray[2]);
        }
    }