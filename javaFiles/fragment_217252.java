PrintWriter out = new PrintWriter(file);

for(int i = 0; i<vrst; i++)
{
    System.out.println();
    out.println();
    for (int j = 0; j<sedezev; j++)
    {
        dvorana [i][j] = r.nextInt(3);  
        System.out.print(dvorana[i][j]);          
        out.print(dvorana[i][j]);
    }   
}

out.close();