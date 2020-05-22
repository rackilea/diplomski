int totalResults = 10;
int pageSize = 3;
int result;

if (totalResults % pageSize == 0) {
    result = totalResults / pageSize;
} else {
    result = totalResults / pageSize + 1;
}