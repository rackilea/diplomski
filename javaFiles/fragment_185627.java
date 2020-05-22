mongocxx::client conn{ mongocxx::uri{ "mongodb://localhost:27017" } };

        bsoncxx::builder::stream::document document{};
        mongocxx::write_concern writeConcern;
        writeConcern.acknowledge_level(mongocxx::write_concern::level::k_unacknowledged);
        std::chrono::milliseconds timeout = std::chrono::milliseconds(5000);
        auto collection = conn["TestDB"]["fdevices"];
        collection.write_concern(writeConcern);
        conn.write_concern(writeConcern);

 QFile inputFile(path);
 if (inputFile.open(QIODevice::ReadOnly))
 {
 QTextStream in(&inputFile);
 while (!in.atEnd())
 {
    QString line = in.readLine();
    std::string utf8_text = line.toUtf8().constData();
    document << "Data" << utf8_text;
    collection.insert_one(document.view());
     }
 inputFile.close();
  }