public class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
...

Interval first = intervals.get(0);
int start = first.start;
int end = first.end;

ArrayList<Interval> result = new ArrayList<Interval>();

for(int i = 1; i < intervals.size(); i++){
    Interval current = intervals.get(i);
    if(current.start <= end){
        end = Math.max(current.end, end);
    }else{
        result.add(new Interval(start, end));
        start = current.start;
        end = current.end;
    }
}