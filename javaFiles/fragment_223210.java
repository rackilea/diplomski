void render(Canvas canvas)
{
m_Src = new Rect(0, 0, m_RectWidth, m_RectHeight);
m_Dst = new Rect(m_RectX, m_RectY, m_RectX + m_RectWidth, m_RectY + m_RectHeight);
canvas.drawBitmap(m_Bitmap, m_Src, m_Dst, null);
}