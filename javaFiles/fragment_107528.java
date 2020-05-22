String url = "https://www.uni.it/it/ateneo-org_plot-pesc/organ/organi-amm/rettore-o_0-rect"; 
URL theURL = new URL(url);
String path = theURL.getPath();
String[] parts = path.split("[/_-]");

for (String part : parts)  {
    System.out.println(part + " ");
}

it ateneo org plot organ organi amm rettore o 0 rect