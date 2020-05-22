fetch(...)
.then(res => res.blob())
.then(blob => {
  const blobURL = URL.createObjectURL(blob);

  // create our <a> to force a download for the response
  const dl = document.createElement(`a`);
  dl.href = blobURL;
  dl.download = `sample.json`;

  // In order for the link to "trigger" we need to add it to the document.
  // If we don't, dl.click() won't do anything. So add it, click it, then remove it.
  dl.style.display = `none`;
  document.body.appendChild(dl);
  dl.click();
  document.body.removeChild(dl);
});