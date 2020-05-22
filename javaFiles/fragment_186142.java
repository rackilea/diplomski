String str = "[\"Hossain, Ziaul\",\"Sathiaseelan, Arjuna\",\"Secchi, Raffaello\",\"Fairhurst, Gorry\"]";


String [] str1 = str.split("\\[\"|\",\"|\"\\]");
for (int iCount = 0; iCount < str1.length; iCount++)
{
   System.out.println(str1[iCount]);
}