//for writing
cv::FileStorage store(“save.yml", cv::FileStorage::WRITE);
store << “mat” << img;
store.release();

//for reading
cv::FileStorage store(“save.yml", cv::FileStorage::READ);
store[“mat”] >> img;
store.release();