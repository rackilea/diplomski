List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();

    // First split the source String by comma to separate main parts
    String[] mainParts = sourceStr.split(",");

    for (String mainPart: mainParts) {
        // Check if each part contains '-' character
        if (mainPart.contains("-")) {
            // If contains '-', split and add the 2 parts to 2 arrays
            String[] subParts = mainPart.split("-");
            list1.add(subParts[0]);
            list2.add(subParts[1]);

        } else {
            // If does not contain '-', add complete part to 1st array and add placeholder to 2nd array
            list1.add(mainPart);
            list2.add("0");
        }
    }

    // Build the final Strings by joining String parts by commas and enclosing between parentheses
    String str1 = "{" + String.join(",", list1) + "}";
    String str2 = "{" + String.join(",", list2) + "}";

    System.out.println(str1);
    System.out.println(str2);