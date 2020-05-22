inputStream.groupByKey().windowedBy(TimeWindows.of(TimeUnit.MINUTES.toMillis(300000)))
.aggregate(PayloadAggr::new, new Aggregator<String, Payload, PayloadAggr>() {
        @Override
        public PayloadAggr apply(String key, Payload newValue, PayloadAggr result) {
            result.setKey(key);
            if(result.getEmails()==null){
                result.setEmails(newValue.getEmail());
            }else{
                result.setEmails(result.getEmails() + "," + newValue.getEmail());
            }
            return result;
        }
    }, .../* You serdes and store */}).toStream().to(OUTPUT_TOPIC);