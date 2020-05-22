uint16_t schemaId;
uint64_t lastModifiedDate;
uint32_t attributeLength;
char buffer[8]; // sized for the biggest read we want to do

// read two bytes (will be in the wrong order)
myfile.read(buffer, 2);
// swap the bytes
std::swap(buffer[0], buffer[1]);
// only now convert bytes to an integer
schemaId = *reinterpret_cast<uint16_t*>(buffer);

// read eight bytes (will be in the wrong order)
myfile.read(buffer, 8);
// swap the bytes
std::swap(buffer[0], buffer[7]);
std::swap(buffer[1], buffer[6]);
std::swap(buffer[2], buffer[5]);
std::swap(buffer[3], buffer[4]);
// only now convert bytes to an integer
lastModifiedDate = *reinterpret_cast<uint64_t*>(buffer);