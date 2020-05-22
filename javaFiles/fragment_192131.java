ImageView imageView = itemView.findViewById(R.id.imageview);
Random random = new Random();
List<Integer> prevInts = new ArrayList<>();
Picasso.get().load(icons[randomUniqueInteger()]).into(imageView);

public int randomUniqueInteger(){
    int p = 0;
    do {
        p = random.nextInt(icons.length);
    } while(prevInts.contains(p));

    if ((prevInts.size + 1) == icons.length){
       prevInts.clear();
    }

    prevInts.add(p);

    return p;
}