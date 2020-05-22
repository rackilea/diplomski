public void setInterval(Date newStart, Date newEnd)
{
 // Check if inputs are correct

 // Here the object state is valid
 start = newStart;

 // If another thread accesses this object now it will
 // see an invalid state because start could be greater than end

 end = newEnd;
 // Here the object state is valid again
}