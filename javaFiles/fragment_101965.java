if(walked.size() > 0)
for(int i = 1; i < walked.size(); i++) { 
    Movement current = walked.get(i); 
    Movement prev = walked.get(i-1);
    Toast(TimeCal.getDuration(current.getTime(), prev.getTime()) + " min(s)") 
}