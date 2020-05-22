Pattern pattern = Pattern.compile("\\d+");
                String s = scanner.nextLine();
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    System.out.println(s.substring(matcher.start(), matcher.end()));
                } else {
                    // TODO The user didn't give us a number...
                }