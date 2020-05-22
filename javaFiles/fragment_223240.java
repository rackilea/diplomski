String name = "Tom Butterfly";
String[] array = addressbook.keySet().toArray(new String[] {});
int firstElement = Collections.binarySearch(Arrays.asList(array),
        name, new Comparator<String>() {

            @Override
            public int compare(String top, String bottom) {
                if (addressbook.get(top).contains(bottom)) {
                    return 0;
                }
                return -1;
            }
        });
System.out.println("Number is " + array[firstElement]);