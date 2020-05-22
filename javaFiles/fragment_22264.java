QNetworkAccessManager *manager = new QNetworkAccessManager(this);
QUrl url("http://192.168.0.101:8000");
url.port(8000);

QByteArray postData;
QNetworkRequest request(url);
request.setHeader(QNetworkRequest::ContentTypeHeader, "application/x-www-form-urlencoded");

QString postKey("some data");
postData.append(postKey);
QObject::connect(manager, SIGNAL(finished(QNetworkReply *)), this, SLOT(replyFinished(QNetworkReply *)));

manager->post(request, postData);