final Pattern lastIntPattern = Pattern.compile("[^0-9]+([0-9]+)$");
            String input = D101;
            Matcher matcher = lastIntPattern.matcher(input);
            if (matcher.find()) {
                String someNumberStr = matcher.group(1);
                int lastNumberInt = Integer.parseInt(someNumberStr);
                System.out.println("Test int output - " + lastNumberInt);
                inputList.add(lastNumberInt);
            }