do {
n = input . nextDouble ();
if (n !=0) v. add (n);
} while (n !=0);
for(int i=0; i<=v.size()-1; i++) {
    sum += v.get(i);
  }
}
average=sum/v.size();