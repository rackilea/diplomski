URL url = new URL("https://www.ietf.org/timezones/data/leap-seconds.list");
BufferedReader br =
    new BufferedReader(
        new InputStreamReader(url.openStream(), "US-ASCII"));
String line;
PlainDate expires = null;
Moment ntpEpoch = PlainTimestamp.of(1900, 1, 1, 0, 0).atUTC();
List<PlainDate> events = new ArrayList<PlainDate>();

try {
    while ((line = br.readLine()) != null) {
        if (line.startsWith("#@")) {
            long expraw = Long.parseLong(line.substring(2).trim());
            expires = ntpEpoch.plus(
              expraw, TimeUnit.SECONDS)
            .toZonalTimestamp(ZonalOffset.UTC).toDate();
            continue;
        } else if (line.startsWith("#")) {
            continue; // comment line
        }

        // this works for some foreseeable future
        long epoch = Long.parseLong(line.substring(0, 10)); 

        // this is no leap second 
        // but just the official introduction of modern UTC scale
        if (epoch == 2272060800L) {
            continue;
        }

        // -1 because we don't want to associate 
        // the leap second with the following day
        PlainDate event = 
          ntpEpoch.plus(epoch - 1, TimeUnit.SECONDS)
                  .toZonalTimestamp(ZonalOffset.UTC).toDate();
        events.add(event); // we don't assume any negative leap seconds here for simplicity
    }
} finally {
    br.close();
}

// now let's write the result into time4j-format
// use a location relative to class path of main program (see below)
String path = "C:/work/leapseconds.txt"; 
Writer writer = new FileWriter(new File(path));
String sep = System.getProperty("line.separator");

try {
    for (PlainDate event : events) {
        writer.write(event + ", +" + sep);
    }
    writer.write("@expires=" + expires + sep);
} finally {
    writer.close();
}

System.out.println(
  "Leap second file was successfully written from IETF-resource.");

// And finally, we can start the main program in a separate process
// with the system property "net.time4j.scale.leapseconds.path"
// set to our leapsecond file path (must be relative to class path)