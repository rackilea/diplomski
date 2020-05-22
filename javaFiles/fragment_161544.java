/*max bytes to read at once*/
static const qint64 CHUNK_SIZE = 1024;

/*init hash*/
QCryptographicHash hash(Sha1);

/*open file*/
QFile file("foo.bar");
if (!file.open(QIODevice::ReadOnly))
    return;

/*process file contents*/
QByteArray temp = file.read(CHUNK_SIZE);
while(!temp.isEmpty())
{
    hash.addData(temp);
    temp = file.read(CHUNK_SIZE);
}

/*finalize*/
const QByteArray res = hash.result();
qDebug("Hash is: %s", res.toHex());