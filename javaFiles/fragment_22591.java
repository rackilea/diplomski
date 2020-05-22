int k = Integer.parseInt(scanner.nextLine().substring("=")[1]);
String currentLine;
for (int i = 0; i < 2; i++)
   currentLine = scanner.nextLine().substring(currentLine.indexOf(" ") + 1)
   for (int j = 0; j < 2; j++)
       array[i][j] = currentLine.split(" ")[j];
   }
}