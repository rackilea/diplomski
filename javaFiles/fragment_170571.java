// to count length
int length = 0;
BufferedReader br =
        new BufferedReader(inputStreamReader);
while(true){
            str = br.readLine();
            if(str == null) break;
            else length++;
} // this loop counts the length!! 
final int clength = length;

//now this is what you want! 
String words[] = new String[clength];
int j= 0;
while(true){
            str = bufferedReader.readLine();
            if(str == null) break;
            words[j++] = str;
            System.out.println(str); //FIXED
}
//Now the words[] have all the lines individually