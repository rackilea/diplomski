Class<?> enumElement = Class.forName("org.myname.test.Element");
Object[] enumElements = elements.getEnumConstants();

Object element1 = enumElements[0];

ElementProvider elementProvider = ElementProvider.class.getDeclaredConstructor(String.class, enumElement).newInstance("Hello", element1);