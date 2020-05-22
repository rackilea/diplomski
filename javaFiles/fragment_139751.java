Container[getInitBoxCount()] shipments //create an array of containers with the size of the inital box count 

for(Container c : shipments)
{
    c = new LargeContainer();
}


Container[] check; //create new objects into the check array. dont set one array = to anoter

do
{
    check = shipments //create new objects into the check array. dont set one array = to anoter
    for(Container c: shipments)
        getSmallestBox(5, c);
    combineBoxes(shipments);
}
while(check == shipments)