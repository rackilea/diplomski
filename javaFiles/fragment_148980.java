ArrayList<String> control = new ArrayList<String>();

try {
    Scanner scan = new Scanner(robotok);

    while (scan.hasNextLine()) {
        String line = scan.nextLine();
        control.add(line);
    }
} catch(Exception e){
}

int coords[][] = new int[control.size()][2]; // index = robot sorszáma / [] Hosszúság / [] Szélesség

for (int i = 0;i<control.size();i++) {
    char[] directions = control.get(i).toCharArray();

    for (int j =0;j<directions.length;j++) {
        if (directions[j] == 'N') {
            coords[i][0] --;
        }else if (directions[j] == 'S'){
            coords[i][0] ++;
        }else if (directions[j] == 'W'){
            coords[i][1] --;
        }else if (directions[j] == 'E'){
            coords[i][1] ++;                     /////THIS IS 36///// 
        }
    }
}

for (int i =0;i<coords.length;i++) {
     System.out.print("The "+i+". ship's coords: "+coords[i][0]+" ; "+coords[i][1]);
}