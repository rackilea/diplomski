import java.lang.Math;
public class Advisor_Score {
    public static void main(String[] args){ 
        double l[] = {1};
        double k[] = {2,2};
        double m[] = {3,3,3};
        double All_users[][]={l,k,m};
        double sum[]={0,0,0};
        double [] raw_advisor=new double [3];
        double [] advisor_score_scaled= new double [3];
        double []advisor_score= new double [3];
        for (int i=0;i<All_users.length;i++){
                for(int j=0;j<All_users[i].length;j++){
                        sum[i]+=All_users[i][j];
                }
                raw_advisor[i]=(sum[i]-(3*All_users[i].length))/4;
                advisor_score_scaled[i]= 2.5*(1-Math.pow(Math.E, -.5*raw_advisor[i]));
                advisor_score[i] = (2.5 + advisor_score_scaled[i]);
                System.out.println(advisor_score[i]);
                }       
    }
}