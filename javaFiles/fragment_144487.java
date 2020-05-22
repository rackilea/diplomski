index = 0
twoSeen = false
threeSeen = false
for each item {
   if (item == 2) {
      twoSeen = true
   }
   if (item == 3) {
      threeSeen = true
   }
   print(item)
   index = index + 1
   if (index == 10) {
      printReport(twoSeen,threeSeen)
      index = 0
      twoSeen = false
      threeSeen = false
   }
}