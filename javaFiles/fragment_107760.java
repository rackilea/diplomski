// Here we have a SpecialBox class that inherits Box, since it has its own type
// we must check for both BOX or SPECIAL_BOX
if(old->getType() == BOX || old->getType() == SPECIAL_BOX) {
   Box* box = static_cast<Box*>(old);
   // Do something box specific
}