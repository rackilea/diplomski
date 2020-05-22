String startTime = "23:40";
int minutes = 30;

String[] hm = startTime.split(":");
int h = Integer.parseInt(hm[0]);
int m = Integer.parseInt(hm[1]);

int t = h * 60 + m;      // total minutes
t += minutes;            // add the desired offset

while (t < 0) {          // fix `t` so that it's never negative
  t += 1440;             // 1440 minutes in a day
}

int nh = (t / 60) % 24;  // calculate new hours
int nm = t % 60;         // calculate new minutes

String newTime = String.format("%02d:%02d", nh, nm);