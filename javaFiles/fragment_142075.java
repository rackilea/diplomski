SimpleDateFormat sf1 = new SimpleDateFormat("dd/MM/yyyy 'alle' HH:mm:ss");
        sf1.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
        System.out.println(sf1.format(new Date()));

// List all Timezone
        System.out.println(Arrays.asList(TimeZone.getDefault()));