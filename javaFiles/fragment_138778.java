String[] words = "I'm am going to the Go-station.".split(" ");
int index = words[words.length - 1].toLowerCase().indexOf("go");

if (index == -1) {
System.out.println("Not found");
} else {
int result = "I'm am going to the Go-station.".length() - words[words.length - 1].length() + index;
System.out.println("found it at postion: " + result);
}