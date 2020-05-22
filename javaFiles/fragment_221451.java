class Weapon {
     private final String name;
     private final int damage;
     private final int ammo;
     public Weapon(final String name,final  int damage,final  int ammo) {
         this.name = name;
         this.damage = damage;
         this.ammo = ammo;
     }
     public Weapon clone() {
         return new Weapon(this.name,this.damage,this.ammo);
     }
     public String getName() {
         return this.name;
     }
     public int getAmmo() {
         return this.ammo;
     }
     public int getDamage() {
         return this.damage;
     }
 }

 class WeaponFactory {
      static WeaponFactory factory;
      public static WeaponFactory getWeaponFactory() {
           if(factory == null) {
               factory = new WeaponFactory();
           }
           return factory;
      }
      private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
      private Random random;
      private WeaponFactory() {
           //TODO: Fix Ammo and Damage
           weapons.add(new Weapon("M4",0,0));
           weapons.add(new Weapon("M16",0,0));
           weapons.add(new Weapon("M9",0,0));
           weapons.add(new Weapon("Glock",0,0));
           weapons.add(new Weapon("SCAR",0,0));
      }
      public Weapon getWeapon() {
          int w = random.nextInt(weapons.length);
          return weapons.get(w).clone();
      }
 }

 class Combat {
      ...
      private void enemyDead() {
           if(ranNumberGen(chanceOfDrop)==0){
                 Player.addInventory(WeaponFactory.getWeaponFactory().getWeapon());
           }
      }
 }