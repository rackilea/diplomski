....
    inet = null;
    bcast = null;
    mask = null;
    ....
    while ((ipaddress = ifconfigProcReader.readLine()) != null) {
            if (inet != null && bcast != null && mask != null)
            {
                break;
            }
            if (inet == null)
            {
                inet = search("inet addr:[0-9.]+", ipaddress, "inet addr:");
            }
            if (bcast == null)
            {
                bcast = search("Bcast:[0-9.]+", ipaddress, "Bcast:");
            }
            if (mask == null)
            {
                mask = search("Mask:[0-9.]+", ipaddress, "Mask:");
            }
        }
    //check if you have got all the ip address populated
    // in inet, bcast, mask
    ....
    ....


        private String search(String regex, String line, String removeString)
        {
            Pattern compiledPattern = Pattern.compile(regex);
            Matcher matcher = compiledPattern.matcher(line);
            String ipAddress = null;
            if (matcher.find())
            {
                ipAddress = matcher.group().replaceFirst(removeString, "");
            }
            return ipAddress;
        }