package com.rizze.test.labs.sof.gamegun;

import org.junit.Test;

public class GameGunTest {


    @Test
    public void betterCode2() {

        Game sleep = new Game("SLP-1","Sleep Weapon","A Custom Made Gun");
        Gun gun = new Gun();
        Sword sword = new Sword();

        gun.hit();
        sword.hit();
        sword.hit();
        sword.hit();
        gun.hit();
    }



    public class Gun implements IWeapon {

        private int damage;
        private String name;

        public Gun(int damage)
        {
            this.damage = damage;
            this.reload();
        }

        public Gun()
        {
            this.damage = 10;
            this.name= "Revolver Gun";
            this.reload();
        }

        @Override
        public int getDamages() {

            return this.damage;
        }

        /**
         * 
         * @return damages
         */
        @Override
        public int hit() {
            System.out.println( this.name + ":Gun shots => "+damage +" damage(s)");
            return this.damage;
        }

        @Override
        public void reload() {
            System.out.println(this.name+":Gun reloaded");          
        }

    }


    public class Sword implements IWeapon {

        private String name;
        private int damage;

        public Sword(String name){  
            this.damage = 5;
            this.name=name;

        }

        public Sword(){ 
            this.damage = 5;
            this.name="Basic Sword";

        }

        @Override
        public int getDamages() {

            return this.damage;
        }

        /**
         * 
         * @return damages
         */
        @Override
        public int hit() {
            System.out.println( name+ ":Sword cuts =>  "+damage +" damage(s)");
            return damage;
        }

        @Override
        public void reload() {
            System.out.println( name+ ":Sword - skipped reload" );          
        }

    }





    public class Game implements IGame {

        private String id;
        private String name;
        private String desc;

        public Game(String ID, String name, String Desc)
        {
            this.id = ID;
            this.name = name;
            this.desc = Desc;
        }

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public String getName() {
            return this.getName();
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }



}
//IGAME

public interface IGame {

    String getId();
    String getName();
    String getDesc();
}


 //IWEAPON 

package com.rizze.test.labs.sof.gamegun;

    public interface IWeapon {
        int getDamages();
        int hit();
        void reload();
    }