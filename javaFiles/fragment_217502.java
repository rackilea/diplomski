import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NewClass {
    public static void doThing(int nums[],int m){
        int n=nums.length;
        ColorNumber l[]=new ColorNumber[n];
        for(int i=0;i<n;i++)
            l[i]=new ColorNumber(nums[i], i%m);
        System.out.println(Arrays.asList(l));
        Arrays.sort(l, null);
        List printlist=Arrays.asList(l);
        System.out.println(printlist);
        int present[]=new int[m];
        int head=0,tail=0;
        int minhead=0,mintail=0,mindiff=Integer.MAX_VALUE;
        while(head<n){
            System.out.println("try growing");
            int i=0;
            while(i<m && head<n){
                while(present[i]==0 && head<n){
                    present[l[head].color]++;
                    head++;
                }
                //if(present[i]>0)i++;           // the bug
                while(i<m && present[i]>0)i++;   // the fix
            }
            if(i==m){
                System.out.println(printlist.subList(tail, head));
                System.out.println("try shrinking");
                while(present[l[tail].color]>1){
                    present[l[tail].color]--;
                    tail++;
                }
                int diff=l[head-1].number-l[tail].number;
                System.out.println(printlist.subList(tail, head)+" diff: "+diff);
                if(diff<mindiff){minhead=head;mintail=tail;mindiff=diff;}
                present[l[tail].color]--;
                tail++;
            }
        }
        System.out.println("min: "+mindiff+", "+printlist.subList(mintail, minhead));
    }

    static class ColorNumber implements Comparable<ColorNumber>{
        final int number;
        final int color;

        public ColorNumber(int number, int color) {
            this.number = number;
            this.color = color;
        }

        @Override
        public int compareTo(ColorNumber o) {
            return number-o.number;
        }

        @Override
        public String toString() {
            return number+"("+color+")";
        }
    }

    public static void main(String args[]){
        Random r=new Random(0);
        int nums[]=new int[10];
        for(int i=0;i<nums.length;i++)
            nums[i]=r.nextInt(100);
        doThing(nums, 3);
        System.out.println("---");
        doThing(new int[]{10,20,15,28},2);
        System.out.println("---");
        doThing(new int[] {2,1},2);              // test case for bug
    }
}