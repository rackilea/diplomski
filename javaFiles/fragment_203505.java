size_t amount_read = 0;
data my_data;
memcpy(buffer+amount_read, &my_data.speed, sizeof(my_data.speed))
amount_read += sizeof(my_data.speed)
memcpy(buffer+amount_read, &my_data.length, sizeof(my_data.length))
amount_read += sizeof(my_data.length)