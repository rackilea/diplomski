void MainWindow::replyFinished(QNetworkReply *reply){
qDebug() << "Status" << reply->errorString();
qDebug() << "Status" << reply->error();


     QByteArray data = reply->readAll(); //It's works!
     qDebug() << "data: " << data;