cind = new String [sumc.length];
dbind = new String [sumc.length]; 
for (int i = 0 ; i <= sumc.length - 1 ; i++){

    String local = sumc[i];

    System.out.println(local);

    String[] parts = local.split(":");
    System.out.println(parts[0]);
    System.out.println(parts[1]);
    cind[i] = local.split(":")[0];
    dbind[i] = local.split(":")[1];

}

System.out.println(Arrays.toString(cind) + "\t");
System.out.println(Arrays.toString(dbind) + "\t");