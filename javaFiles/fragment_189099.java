import java.util.Scanner;
public class Game1 {
public static void main(String[] args) {
    int hp = 10, enemy_hp = 10;
    String attack = "attack";
    String block = "block";
    String heavy = "heavy";
    String light = "light";
    Scanner userInput = new Scanner(System.in);
    while (enemy_hp > 0 && hp > 0) {
        System.out.println("It is your turn, attack (heavy or light) or try to block");
        int your_block_chance1 = (int)(Math.random() * 4); //Chance to block an attack
        int enemy_block_chance1 = (int)(Math.random() * 4);
        String action = userInput.next();
        if (action.equals(attack)) { //attack
            System.out.print("You attacked your enemy and ");
            if (enemy_block_chance1 == 0) {
                System.out.println("he blocked it");
            } else if (enemy_block_chance1 != 0) {
                enemy_hp = enemy_hp - 3;
                System.out.println("managed to hit, now his hp is " + enemy_hp);
            }
        } else if (action.equals(light)) { //light attack
            System.out.print("You want to do a light attack");
            if (enemy_block_chance1 == 0) {
                System.out.println(" but he blocked it");
            } else if (enemy_block_chance1 != 0) {
                enemy_hp = enemy_hp - 1;
                System.out.println(" and you managed to hit him, now his hp is " + enemy_hp);
            }
        } else if (action.equals(block)) { //block
                System.out.println("You dicided to block and rest");
                your_block_chance1 = (int)(Math.random() * 1);
                hp++;
        } else if (action.equals(heavy)) { //heavy attack
                System.out.print("You went for a heavy attack");
                int heavy_attack_chance = (int)(Math.random() * 2);
                if (heavy_attack_chance == 1) {
                    System.out.println(" but failed");
                } else if (heavy_attack_chance != 1) {
                    if (enemy_block_chance1 == 0) {
                        System.out.println(" but he blocked it");
                    } else if (enemy_block_chance1 != 0) {
                        enemy_hp = enemy_hp - 6;
                        System.out.println(" and you managed to hit you really hard, now his hp is " + enemy_hp);
                    }
                }
        }
            System.out.print("It is your enemy turn, he decided to "); //enemy turn 
            int enemy_action2 = (int)(Math.random() * 4);
            if (enemy_action2 == 1) {
                System.out.print("attack you,"); //attack
                if (your_block_chance1 == 0) {
                    System.out.println(" but you blocked it");
                } else if (your_block_chance1 != 0) {
                    hp = hp - 3;
                    System.out.println(" and you didn't block it, now your hp is " + hp);

                }
            } else if (enemy_action2 == 0) { //heavy attack
                System.out.print("do a heavy attack");
                int heavy_attack_chance = (int)(Math.random() * 2);
                if (heavy_attack_chance == 1) {
                    System.out.println(" but failed");
                } else if (heavy_attack_chance != 1) {
                    if (your_block_chance1 == 0) {
                        System.out.println(" but you blocked it");
                    } else if (your_block_chance1 != 0) {
                        hp = hp - 6;
                        System.out.println(" and he managed to hit you really hard, now your hp is " + hp);
                    }
                }
            } else if (enemy_action2 == 3) { //light attack
                System.out.print("do a light attack");
                if (your_block_chance1 == 0) {
                    System.out.println(" but you blocked it");
                } else if (your_block_chance1 != 0) {
                    hp = hp - 1;
                    System.out.println(" and he managed to hit you, now your hp is " + hp);
                }
            } else if (enemy_action2 == 2) { //block
                System.out.println("block and rest");
                enemy_hp++;
            }
        }
        if (hp <= 0) {
            System.out.println("You failed");
        } else if (enemy_hp <= 0) {
            System.out.println("You won!");
        }
    }