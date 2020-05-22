struct FileChunk {
  1: binary data
  2: i64 remaining
}

service StreamFileService {    
   FileChunk getBytes(1:string fileName, 2: i64 offset, 3: i32 size);    
}