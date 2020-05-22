public class MainActivity extends Activity {
    ...
    public void threePointsThrow(View v) {
        switch (v.getId()) {
            case R.id.team_1_3_points:
                basketTeam1.threePointsThrow();
                break;
            case R.id.team_2_3_points:
                basketTeam2.threePointsThrow();
                break;
            default:
                break;
        }
    }
}