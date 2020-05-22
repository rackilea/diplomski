Object hinfo = hmap.get(s);
        if (hinfo.toString().replaceAll("\\([^\\(]*\\)", "").equals("aze.kunde.schluessel")) {
            Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(hinfo.toString());
            while (m.find()) {
                jmo[obj].setAzeKundeSchluessel(Long.parseLong(m.group(1), 10));
                // logger.info("AzeKundeSchluessel: " +
                // jmo[obj].getAzeKundeSchluessel());
            }
        } else ...