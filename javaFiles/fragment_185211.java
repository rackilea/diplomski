BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
ArrayList<Integer> basicpg = new ArrayList<Integer>();
String input;
while((input = br.readLine()) != null && input.length() != 0)
{
    basicpg.add(Integer.parseInt(input));
}