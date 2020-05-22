socket.on('end',function(){
    console.log(imageData.length)
    var decoded = Buffer.from(imageData, 'base64');
    fs.writeFileSync(new Date()+".png", decoded, function (err) {
        if (err) throw err;
        else  console.log('Saved!');
    });
});