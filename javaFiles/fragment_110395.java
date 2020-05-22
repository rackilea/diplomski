List<SpotLight> spotlights = new ArrayList<>();
for(int i = 0; i < 20; i++)
    spotlights.add(new SpotLight("Off"));

int choice = 0;
do {
    System.out.println("Select a light to turn on 1-20");
    choice = sc.nextInt();
} while(choice < 1 || choice > 20);

spotlights.get(choice - 1).on();

System.out.println(spotlights);